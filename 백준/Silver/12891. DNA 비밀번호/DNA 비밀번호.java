import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int checkArr[];		// 비밀번호 체크 배열
	static int myArr[];			// 현재 상태 배열
	static int checkSecret;		// 몇 개의 문자와 관련된 개수를 충족했는지 판단
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int s = Integer.parseInt(st.nextToken());	// 문자열 크기
		int p = Integer.parseInt(st.nextToken());	// 부분 문자열 크기
		int result = 0;		// 최종 결과
		
		char a[] = new char[5];
		checkArr = new int[4];	// 비밀번호 체크 배열
		myArr = new int[4];		// 현재 상태 배열
		checkSecret = 0;
		
		a = bf.readLine().toCharArray();
		st = new StringTokenizer(bf.readLine());
		
		for (int i = 0; i < 4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			if (checkArr[i] == 0) {
				checkSecret++;
			}
		}
		
		for (int i = 0; i < p; i++) {	// 초기 p 부분 문자열 배열 처리 부분
			Add(a[i]);
		}
		
		if (checkSecret == 4) {
			result++;
		}
		
		// 슬라이딩 윈도우 처리 부분
		for (int i = p; i < s; i++) {
			int j = i - p;	
			// 한 칸씩 이동하면서 제거되는 문자열과 새로 들어오는 문자열을 처리하기
			// 유효한 비밀번호인지(checkSecret == 4) 판단해 결과값에 업데이트
			Add(a[i]);
			Remove(a[j]);
			if (checkSecret == 4) {		// 4자릿수와 관련된 크기가 모두 충족될 때 유효한 비밀번호
				result++;
			}
		}
		
		System.out.println(result);
		bf.close();
	}
	
	
	
	public static void Add(char c) {	// 새로 들어온 문자를 처리하는 함수
		switch(c) {
		case 'A':
			myArr[0]++;
			if (myArr[0] == checkArr[0]) {
				checkSecret++;
			}
			break;
		case 'C':
			myArr[1]++;
			if (myArr[1] == checkArr[1]) {
				checkSecret++;
			}
			break;
		case 'G':
			myArr[2]++;
			if (myArr[2] == checkArr[2]) {
				checkSecret++;
			}
			break;
		case 'T':
			myArr[3]++;
			if (myArr[3] == checkArr[3]) {
				checkSecret++;
			}
			break;
		}
	}

	public static void Remove(char c) {		// 제거되는 문자를 처리하는 함수
		switch (c) {
		case 'A':
			if (myArr[0] == checkArr[0]) {
				checkSecret--;
			}
			myArr[0]--;
			break;
		case 'C':
			if (myArr[1] == checkArr[1]) {
				checkSecret--;
			}
			myArr[1]--;
			break;
		case 'G':
			if (myArr[2] == checkArr[2]) {
				checkSecret--;
			}
			myArr[2]--;
			break;
		case 'T':
			if (myArr[3] == checkArr[3]) {
				checkSecret--;
			}
			myArr[3]--;
			break;
		}
	}
}
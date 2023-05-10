function solution(a, b) {
    let date = new Date;
	
	date.setMonth(a-1);
	date.setDate(b);
	date.setFullYear(2016);
    
	let week = date.getDay();
    let result;
    
    if (week == 0) {
		result = "SUN";
	} else if (week == 1) {
		result = "MON";
	}  else if (week == 2) {
		result = "TUE";
	}  else if (week == 3) {
		result = "WED";
	}  else if (week == 4) {
		result = "THU";
	}  else if (week == 5) {
		result = "FRI";
	}  else if (week == 6) {
		result = "SAT";
	}
    
    
    var answer = result;
    return answer;
}
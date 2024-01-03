// 2-3 자료형과 형변환(코드 실행 ctrl + alt + n)
let age = 25; // 정수

let tall = 175.9; // 실수 

let inf = Infinity;

let minusInf = -Infinity;

let nan = NaN;

console.log(age * tall);

// 문자열 타입
let name = "winterlood";

let name2 = '김요한';
// 문자열안에 변수의 값을 집어넣을 수 있도록 ``를 활용하여 할 수 있다. 
// 템플릿 리터럴이라고 한다.
let name3 = `winterlood ${name2}`;
console.log(name3);

// 불린형이다. 불린형은 앞에 변수 앞에 is를 붙인다.
let isSwitchOff = false;

// null이다. null은 의도적으로 아무값도 없다라는 걸 가리킬때 사용한다.
let a = null;
console.log(a);

// 마지막은 undfined이다.
let variable;

console.log(variable);

// 자동형변환, 문자열 2를 숫자2로 자료형으로 변환시키는 걸 형변환 캐스팅이라 한다.
// 묵시적 형변환(자동으로 자바스크립트도 형변환 해주는 것)
// 덧셈은 숫자를 문자열로 바꿔서 문자열로 붙였다.
// parseInt 문자열을 정수로 바꿔주는 함수이다.
let numberA = 12;

let numberB = "2";

console.log(numberA + parseInt(numberB));

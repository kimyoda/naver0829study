// 형변환
// 자바스크립트가 문자열 2를 자동으로 변환하여 실행시켜서 그렇다.
// 적절하게 자료형을 변환시켜주는 기능을 갖고 있다.
// 묵시적 형변환이라 한다.(의도x)
let numberA = 12;
let numberB = "2";

console.log(numberA * numberB);
// +는 문자열로 인식되어 계산되었다.
// parseInt로 문자열값을 정수로 변환하는 함수이다.
// 명시적형변환(의도적으로)
console.log(numberA + parseInt(numberB));

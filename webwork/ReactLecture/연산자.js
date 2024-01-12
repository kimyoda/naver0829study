// 2-4 연산자(코드 실행 ctrl + alt + n)
// 대입연산자(a 를 1로 대입하는 걸 대입연산자라고 함)
// let a = "1";

// 산술 연산자(사칙연산)
// let b = "2";

// console.log(a + b);

// console.log(a * b);

// console.log(a - b);

// console.log(a / b);

// console.log(a % b);

// 연결 연산자(두개 이상의 문자열을 이어붙이는 연산을 연결연산이라함)
// 다만, 값이 숫자로 되어있어도 연결연산자로 바뀜, 묵시적 형변환때문에 숫자형 값을 문자형으로 바꾼다.
// 덧셈을 할 때 숫자인지 확인해야한다.
// console.log(a + b);

// 복합 연산자(+=의 의미는 a += 10 === a = a + 10과 같다는 의미이다.)
// let a = 5;
// a = a + 10;
// -, *, /다 가능하다
// a += 10;
// console.log(a);

// 증감연산자(원시타입 중 숫자형에만 가능하다, 산술 연산자를 두번 쓰는 것이다)
// --도 당연히 가능하다. 증감연산자는 뒤에 붙일수도 있고 앞에 붙일 수도 있다.
// 뒤에 쓰게 되면, 라인이 끝나고 나서 값이 올라게 된다.
// 증감연산자를 뒤에 쓰는 방식을 후위연산이라고 한다.(마이너스도 같다)
// 앞에 붙이는건 바로 적용이 된다. 앞에 붙이는 것을 전위연산이라고 한다.
// let a = 10;
// a++;
// console.log(a++);
// console.log(a);

// 논리연산자(불린) !는 Not이라는 의미이다. 반대로 바꾸는 의미
// AND는 피연산자 2개가 다 참일 경우에만 참이다.
// OR는 피연산자 1개가 참일 경우에 참이다. 둘다 거짓이면 거짓의 값이 나온다.
// console.log(!true);
// console.log(true && true) // true And true
// console.log(true && false) // true And true
// console.log(true || false) // true Or true

// 비교연산자(==의 값이 앞에 값에 저장된다)
// ===는 값과 타입이 모두 같아야 true가 나올 수 있다.
// let compareA = 1 === "1";
// 값만 이 두값이 같지않냐고 비교하는 건 !=을 하면 된다.
// 값이 같기 때문에 false가 출력된다. 
// 뒤의 껀 자료형이 다르기 때문에 같지않다기에 true가 나온다
// let compareA = 1 !== "1";
// console.log(compareA);

// 대소비교(<, >, = 처럼 비교하는 값들이다.)
// let compareA = 2 <= 2;
// console.log(compareA);

// 타입을 알수 있는 연산자이다.
// 동적타입언어
// typeof연산자는 변수의 이름을 쓴다면 변수의 자료용이 뭔지 알려준다.
// let compareA = 1;

// compareA = "1";
// console.log(typeof compareA);

// null 병합 연산자
// ??는 널병합 연산자인데 양쪽의 피연산자 중에 null이나 undefined가 아닌 값을 선택한다.
// a에 값을 대입하고 있으므로 ??으로 인해 a가 null이거나 undfined에 해당하기에 10을 선택하여 10이 출력
// a의 값이 undefined인 이유는 변수를 선언하고 할당을 하지 않았기에 자동으로 할당을 받은것이다.
let a;

a = a ?? 10;
console.log(a);
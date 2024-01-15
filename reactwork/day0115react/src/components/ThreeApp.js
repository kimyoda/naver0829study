import React from "react";
import "./MyStyle.css";

function ThreeApp(props) {
  const names = ["리액트", "스프링부트", "자바", "파이썬", "뷰"];

  // 방법 1
  // key 값을 unique 한 값으로 태그에 넣어야 콘솔에 오류가 안난다.
  const nameList = names.map((subject, i) => <li key={subject}>{subject}</li>);

  return (
    <div>
      <h3 className="alert alert-success">반복문</h3>
      {nameList}
      {/* 직접 return 문 안에서 반복해서 출력하는 경우 */}
      {names.map((subject, i) => (
        <h6 key={i}>
          {i} : {subject}
        </h6>
      ))}
      <hr />
      {/* 배열이 아닌 특정숫자 범위로 출력하고자 할 경우 */}
      {/* {[...new Array(10)].map((a, i) => (
        <h5 key={i}>
          {i}:{a}
        </h5>
      ))} */}
      {/* C1.png~c5.png 이미지를 map 을 이용해서 출력하자 */}
      {names.map((subject, i) => (
        <img alt="" src={require(`./images/C${i + 1}.png`)} />
      ))}
    </div>
  );
}

export default ThreeApp;

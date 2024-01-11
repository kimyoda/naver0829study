import React, { useState } from "react";
import "./MyStyle.css";

// rsf = 자동으로 아래의 함수를 만들어주는 것
function SecondApp(props) {
  // let msg = "Happy Day!!!"; // 단순 출력만 가능, 변경은 불가능

  // 변경도 가능하다(useState를 사용한건)
  // msg: 변수명, setMsg : setter 함수명
  const [msg, setMsg] = useState("Nice Day!!");

  return (
    <div className="box2">
      <h5 className="alert alert-success">SecondApp 컴포넌트</h5>
      <h6>메세지를 입력하세요</h6>
      <input
        type="text"
        className="form-control"
        value={msg}
        onChange={(e) => {
          // setter 함수를 통해서 입력값을 msg 에 넣는다
          setMsg(e.target.value); // msg 변수의 값이 변경된다
        }}
      />
      <h1>{msg}</h1>
    </div>
  );
}

export default SecondApp;

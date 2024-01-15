import React, {useState} from "react";
import "./MyStyle.css";

function FiveApp(props) {
  const [msg, setMsg] = useState(["Happy", "Hello", "안녕하세요"]);

  return (
    <div className>
      <h3 className="alert alert-danger">FiveApp-배열-추가/삭제</h3>
      <input
        type="text"
        className="form-control"
        style={{width: "200px"}}
        placeholder="메세지입력"
        onKeyUp={(e) => {
          if (e.key === "Enter") {
            // alert(e.target.value);

            // 배열에 push로 일단 추가해보자 => 안돼는 이유는 원본 배열을 수정해서
            // 새로운 배열의 길이를 반환하기에 안됀다.
            // setMsg(msg.push(e.target.value));

            // 리액트는 배열에 데이타 추가시 concat으로 추가한다
            setMsg(msg.concat(e.target.value));
          }
        }}
      />
      <hr />
      <h6 className="alert alert-success">
        총 {msg.length}개의 메세지가 있습니다 - 더블클릭시 삭제
      </h6>
      {msg.map((m, i) => (
        <h6
          key={i}
          className="select"
          onDoubleClick={(e) => {
            // 방법 1 : slice : 0 - i -1 펼침, i + 1 ~ 끝까지 펼침
            // setMsg([...msg.slice(0, i), ...msg.slice(i + 1, msg.length)]);

            // 방법 2 : filter
            setMsg(msg.filter((item, idx) => i !== idx));
          }}
        >
          {i + 1}:{m}
        </h6>
      ))}
    </div>
  );
}

export default FiveApp;

import React, {useEffect, useState} from "react";
import T1_1 from "./images/T1_1.jpg";
import T1_2 from "./images/T1_2.jpg";
// import "./MyStyle.css";

function TwoApp(props) {
  const [show, setShow] = useState(true);
  const [count, setCount] = useState(1);

  const clickButtonEvent = () => {
    setCount(count + 1);
    // 비동기처리라 아래 코드가 먼저 호출 될 수도 있다.
    // setShow(count % 3 === 0 ? true : false);
  };

  useEffect(() => {
    setShow(count % 3 === 0 ? true : false);
  }, [count]); // count 변경 시 자동호출

  return (
    <div>
      <h3 className="alert alert-danger">
        TwoApp-3의 배수마다 이미지 보이기/안보이기
      </h3>
      <button
        type="button"
        className="btn btn-danger"
        onClick={clickButtonEvent}
      >
        숫자증가
      </button>
      <b style={{fontSize: "4em", color: "red", marginLeft: "50px"}}>{count}</b>
      <br />
      <br />
      {
        // show 가 true 일때 보이는 이미지
        show && <img alt="" src={T1_1} style={{width: "300px"}} />
      }
      {
        // show 가 false 일때 보이는 이미지
        !show && <img alt="" src={T1_2} style={{width: "300px"}} />
      }
      {/* src의 이미지를 import 없이 출력하는 방법 */}
      <img
        alt=""
        src={require("./images/T1_4.jpeg")}
        style={{width: "100px"}}
      />
    </div>
  );
}

export default TwoApp;

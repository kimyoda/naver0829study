import React, {useRef, useState} from "react";
import {Alert, Button} from "@mui/material";

function MainApp(props) {
  const [msg, setMsg] = useState("");
  const nameRef = useRef("");
  const korRef = useRef(0);
  const engRef = useRef(0);

  // 결과확인 버튼 이벤트
  const buttonResult = () => {
    // text로 할때는 value 값도 넣어야한다.
    let name = nameRef.current.value;
    let kor = korRef.current.value;
    let eng = engRef.current.value;
    // 숫자인지 확인 후 경고
    if (isNaN(kor)) {
      alert("국어점수는 숫자로 입력해주세요");
      return;
    }

    if (isNaN(eng)) {
      alert("영어점수는 숫자로 입력해주세요");
      return;
    }
    // 총점, 평균
    let total = Number(kor) + Number(eng);
    let avg = total / 2;

    let score = `
      이름 : ${name}
      국어점수 : ${kor}
      영어점수 : ${eng}
      총점 : ${total}
      평균 : ${avg}
      `;

    setMsg(score); // state 변수 msg에 값 넣기
    // 입력값 초기화
    nameRef.current.value = "";
    korRef.current.value = "";
    engRef.current.value = "";
    nameRef.current.focus();
  };

  return (
    <div>
      <Alert severity="success" variant="filled">
        <h3>TwoApp-useRef 이용해서 값입력하기</h3>
      </Alert>
      <table className="table table-bordered">
        <tbody>
          <tr>
            <th style={{width: "100px"}}>이름</th>
            <td>
              <input type="text" className="form-control" ref={nameRef} />
            </td>
          </tr>
          <tr>
            <th style={{width: "100px"}}>국어점수</th>
            <td>
              <input type="text" className="form-control" ref={korRef} />
            </td>
          </tr>
          <tr>
            <th style={{width: "100px"}}>영어점수</th>
            <td>
              <input type="text" className="form-control" ref={engRef} />
            </td>
          </tr>
          <tr>
            <td colSpan={2} align="'center">
              <Button color="info" variant="outlined" onClick={buttonResult}>
                결과 확인
              </Button>
            </td>
          </tr>
          <tr style={{height: "100px", backgroundColor: "orange"}}>
            <td
              colSpan={2}
              style={{whiteSpace: "pre-line", backgroundColor: "#ffc"}}
            >
              <h4>{msg}</h4>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}

export default MainApp;

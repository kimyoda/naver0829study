import React, {useState} from "react";
import {Alert, Button} from "@mui/material";
import {DeleteForeverRounded} from "@mui/icons-material";

function MainApp(props) {
  const [inputArray, setInputArray] = useState([]);
  const [inputs, setInputs] = useState({
    name: "lee",
    nickname: "hello",
    hp: "010",
    addr: "seoul",
  });

  // 입력 시 inputs 의 해당 멤버변수로 값이 들어가게 하기위한 이벤트
  const inputChangeEvent = (e) => {
    const {name, value} = e.target; // 이벤트가 발생하는 태그의 name과 입력 값 얻기
    setInputs({
      ...inputs, // 기존의 값을 펼침연산자로 일단 넣고
      [name]: value, // 입력한 태그의 name에 값 변경이다.
    });
  };

  // 배열 추가 이벤트
  const addArrayEvent = () => {
    // 기본 배열데이타에 묶음변수인 inputs를 추가
    // setInputArray(inputArray.concat(inputs));
    // 보통의 경우 펼침연산자를 많이 쓴다고 함. 민재한테 사후 확인
    setInputArray([...inputArray, inputs]);
  };

  // 입력값 초기화
  const clearButtonEvent = () => {
    setInputs({
      name: "",
      nickname: "",
      hp: "",
      addr: "",
    });
  };

  // 삭제 이벤트에서 호출해야한다.(이벤트가 아님, 이벤트라는 변수말고는 못온다)
  const deleteData = (idx) => {
    setInputArray(inputArray.filter((a, i) => i !== idx));
  };

  return (
    <div style={{width: "500px"}}>
      <h3 className="alert alert-success">
        ThreeApp-하나의 변수에 여러 값 저장하기
      </h3>
      <table className="table table-bordered">
        <tbody>
          <tr>
            <th style={{width: "100px"}}>이름</th>
            <td>
              <input
                type="text"
                className="form-control"
                value={inputs.name}
                name="name"
                onChange={inputChangeEvent}
              />
            </td>
          </tr>
          <tr>
            <th style={{width: "100px"}}>닉네임</th>
            <td>
              <input
                type="text"
                className="form-control"
                value={inputs.nickname}
                name="nickname"
                onChange={inputChangeEvent}
              />
            </td>
          </tr>
          <tr>
            <th style={{width: "100px"}}>핸드폰</th>
            <td>
              <input
                type="text"
                className="form-control"
                value={inputs.hp}
                name="hp"
                onChange={inputChangeEvent}
              />
            </td>
          </tr>
          <tr>
            <th style={{width: "100px"}}>주소</th>
            <td>
              <input
                type="text"
                className="form-control"
                value={inputs.addr}
                name="addr"
                onChange={inputChangeEvent}
              />
            </td>
          </tr>
          <tr>
            <td colSpan={2}>
              <h5>
                name:{inputs.name}
                <br />
                nickname:{inputs.nickname}
                <br />
                hp:{inputs.hp}
                <br />
                addr:{inputs.addr}
                <br />
              </h5>
            </td>
          </tr>
          <tr>
            <td colSpan={2} align="center">
              <Button color="info" variant="outlined" onClick={addArrayEvent}>
                배열에 추가
              </Button>
              <Button
                color="info"
                variant="outlined"
                onClick={clearButtonEvent}
              >
                입력값 초기화
              </Button>
            </td>
          </tr>
        </tbody>
      </table>
      <hr />
      {/* 배열값 출력 */}
      <table className="table table-bordered">
        <caption align="top">배열갯수 : {inputArray.length}</caption>
        <thead>
          <tr>
            <th>이름</th>
            <th>닉네임</th>
            <th>핸드폰</th>
            <th>주소</th>
          </tr>
        </thead>
        <tbody>
          {inputArray.map((item, idx) => (
            <tr key={idx}>
              <td>
                {item.name}
                &nbsp;&nbsp;
                <DeleteForeverRounded
                  style={{cursor: "pointer"}}
                  onClick={(e) => deleteData(idx)}
                />
              </td>
              <td>{item.nickname}</td>
              <td>{item.hp}</td>
              <td>{item.addr}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default MainApp;

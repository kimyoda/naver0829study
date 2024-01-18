import React from "react";
import {useState} from "react";

const PersonForm = ({onSave}) => {
  const [name, setName] = useState("");
  const [age, setAge] = useState("");
  const [blood, setBlood] = useState("A");
  const [photo, setPhoto] = useState("1.jpg");

  // 추가 버튼 이벤트
  const addButtonEvent = () => {
    if (isNaN(age)) {
      alert("나이는 숫자로만 입력해주세요");
      return;
    }
    // 부모 컴포넌트의 메서드를 통해서 입력한 데이타를 보낸다(키, 값 벨류값이 같을때)
    // 때는 생략이 가능하고 그렇지 않을경우 key, value를 같이 써야한다.
    onSave({name, age, blood, photo});

    // 초기화
    setName("");
    setAge("");
  };

  return (
    <table className="table table-bordered" style={{width: "460px"}}>
      <tbody>
        <tr key="form">
          <th style={{width: "100px", backgroundColor: "pink"}}>이름</th>
          <td>
            <input
              type="text"
              className="form-control"
              style={{width: "130px"}}
              value={name}
              onChange={(e) => setName(e.target.value)}
            />
          </td>
          <th style={{width: "100px", backgroundColor: "pink"}}>나이</th>
          <td>
            <input
              type="text"
              className="form-control"
              style={{width: "130px"}}
              value={age}
              onChange={(e) => setAge(e.target.value)}
            />
          </td>
        </tr>
        <tr>
          <th style={{width: "100px", backgroundColor: "pink"}}>혈액형</th>
          <td>
            <select
              className="form-select"
              onChange={(e) => setBlood(e.target.value)}
            >
              <option>A</option>
              <option>B</option>
              <option>O</option>
              <option>AB</option>
            </select>
          </td>
          <th style={{width: "100px", backgroundColor: "pink"}}>사진</th>
          <td>
            <img alt="" src={require(`../images/${photo}`)} width="40" />
            <select
              className="form-select"
              onChange={(e) => setPhoto(e.target.value)}
            >
              {[...new Array(20)].map((item, i) => (
                <option key={i}>{i + 1}.jpg</option>
              ))}
            </select>
          </td>
        </tr>
        <tr>
          <td colSpan={4} align="center">
            <button
              type="button"
              className="btn btn-outline-danger"
              onClick={addButtonEvent}
            >
              DB 에 추가하기
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  );
};

export default PersonForm;

import React from "react";
import {Alert} from "@mui/material";
import PersonForm from "./PersonFrom";
import axios from "axios";
import {useState} from "react";
import {useEffect} from "react";
import PersonRowItem from "./PersonRowItem";

const OneApp = () => {
  const [personList, setPersonList] = useState([]);

  // 저장 이벤트
  const personInsert = (data) => {
    console.log(data);

    // 스프링부트 서버로 데이타 보내서 db 저장(post는 post와 get은 get으로 맞춰야함.)
    // packge.json에 props 작업을 해놔서 localhost를 안적었다.
    axios
      .post("/person/add", data)
      .then((res) => {
        // 추가 성공 후 목록 다시 출력
        list();
      })
      .catch((error) => {
        console.log("추가 시 에러발생:" + error);
      });
  };

  const list = () => {
    // 백엔드로부터 데이타를 가져와서 배열변수에 넣기
    axios.get("/person/list").then((res) => {
      setPersonList(res.data);
    });
  };

  const deletePerson = (num) => {
    let url = "/person/delete?num=" + num;
    axios.delete(url).then((res) => {
      // 삭제 성공 후 목록 다시 출력
      alert("삭제 성공!!");
      list();
    });
  };

  useEffect(() => {
    console.log("useEffect");
    list(); // 처음 시작 시 무조건 호출, 두번 보이지만 한번만 호출돼는 것이다.
  }, []); // 처음 시작 시 한번만 호출

  return (
    <div>
      <Alert severity="success" variant="filled">
        <h3>OneApp-person DB 추가/목록</h3>
      </Alert>
      <PersonForm onSave={personInsert} />
      <hr />
      <h5>총 {personList.length} 명의 회원이 등록되어있습니다</h5>
      <table className="table table-table-bordered" style={{width: "500px"}}>
        <tbody>
          {personList.map((rowData, idx) => (
            <PersonRowItem
              key={idx}
              row={rowData}
              idx={idx}
              onDelete={deletePerson}
            />
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default OneApp;

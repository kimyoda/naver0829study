import {Alert, Button} from "@mui/material";
import React, {useState} from "react";
import {useNavigate} from "react-router-dom";
import {useEffect} from "react";
import PersonRowItem from "./PersonRowItem";
import axios from "axios";

const PersonList = () => {
  const [list, setList] = useState([]);

  const navi = useNavigate();

  const personList = () => {
    axios
      .get("/person/list")
      .then((res) => {
        setList(res.data);
      })
      .catch((err) => {
        console.log(err.respones);
      });
  };

  // 삭제
  const onPersonDelete = (personNum) => {
    const url = "/person/delete?num=" + personNum;
    axios.delete(url).then((res) => {
      // 삭제 후 목록 다시출력
      personList();
    });
  };

  useEffect(() => {
    personList();
  }, []);

  return (
    <div className="mainbox">
      <Button
        color="success"
        variant="outlined"
        onClick={() => navi("/writeform")}
      >
        멤버추가
      </Button>
      <br />
      <br />
      <Alert variant="filled" severity="info">
        Person 멤버 목록
      </Alert>
      <h5>
        <b>총 {list.length} 명의 회원정보가 있습니다</b>
        <table className="table table-bordered">
          <thead>
            <tr>
              <th style={{width: "80px", backgroundColor: "orange"}}>번호</th>
              <th style={{width: "300px", backgroundColor: "orange"}}>
                회원명
              </th>
              <th style={{width: "120px", backgroundColor: "orange"}}>삭제</th>
            </tr>
          </thead>
          <tbody>
            {
              // list null때는 실행이 안돼고 list가 값이 있으면 실행이 됀다.
              list &&
                list.map((row, idx) => (
                  <PersonRowItem
                    key={idx}
                    row={row}
                    idx={idx}
                    onDelete={onPersonDelete}
                  />
                ))
            }
          </tbody>
        </table>
      </h5>
    </div>
  );
};

export default PersonList;

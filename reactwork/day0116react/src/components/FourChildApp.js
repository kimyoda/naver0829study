import React from "react";
import {Button} from "@mui/material";

function FourChildApp(props) {
  const {name, age, addr} = props; // 읽기 전용, 출력만 가능하다.

  return (
    <div>
      <div className="box">
        {/* {props.name}님의 나이는 {props.age}이며 고향은 {props.addr}입니다. */}
        {name}님의 나이는 {age}이며 고향은 {addr}입니다.
        <Button
          color="info"
          variant="contained"
          style={{marginLeft: "10px"}}
          size="small"
          onClick={() => props.increate()}
        >
          증가
        </Button>
      </div>
    </div>
  );
}

export default FourChildApp;

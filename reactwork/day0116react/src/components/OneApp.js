import React, {useState, useRef} from "react";
import {Alert, Button} from "@mui/material";

function MainApp(props) {
  // Count 증가를 하나는 state로 하나는 ref로 선언 후 증가시켜 보는 예제

  const [count, setCount] = useState(0);
  const countRef = useRef(0);

  console.log("랜더링중....");

  return (
    <div>
      <Alert severity="info" variant="filled">
        <h3>OneApp-useRef: 값이 변경되도 화면이 다시 랜더링되지 않는다</h3>
      </Alert>
      <h1>state : {count}</h1>
      {/* ref는 출력할 때 .current를해야한다 */}
      <h1>ref : {countRef.current}</h1>
      <hr />
      <Button
        variant="outlined"
        color="success"
        onClick={() => setCount(count + 1)}
      >
        count 변수 증가
      </Button>
      <br />
      <Button
        variant="outlined"
        size="small"
        onClick={() => {
          countRef.current = countRef.current + 1; // 버튼을 클릭해도 랜더링이 일어나지 않는다. 그래도 실제 값은 변경돼고 있다.
          // 바로바로 출력해야할때는 state 그게 아니고 게시판의 글처럼 다 하면 바뀌어야 돼는 경우
          // ref를 사용한다. 그리고, 랜더링할 때 같이 바뀐다.
          console.log("countRef.current=" + countRef.current);
        }}
      >
        countRef 변수 증가
      </Button>
    </div>
  );
}

export default MainApp;

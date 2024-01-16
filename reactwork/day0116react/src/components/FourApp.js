import React, {useState} from "react";
import FourChildApp from "./FourChildApp";
// 부모, 자식간의 통신
// 1. 부모컴포넌트에서 자식 컴포넌트로 props 를 통해서 값이나 이벤트를 전달 할 수 있다.
// 2. 자식컴포넌트에서는 부모컴포넌트의 값을 props로 받아서 출력은 가능하지만 직접적으로 변경은 불가능하다.
// 3. 만약 변경하려면 부모의 이벤트를 props를 통해서 호출을 하고 그 이벤트함수에서 변경을 하면 됀다.
// props는 부모 컴포넌트가 설정하며, 컴포넌트 자신은 해당 props 를 읽기 전용으로만 사용할 수 있다.
// 컴포넌트내부에서 읽고 또 업데이트하려면 state를 써야한다.

function MainApp(props) {
  const [count, setCount] = useState(0);

  // count를 증가하는 함수
  const changeCount = () => {
    setCount(count + 1);
  };

  return (
    <div>
      <h3 className="alert alert-danger">FourApp-부모, 자식간 통신</h3>
      <h4>
        <b>방문횟수 : {count}회</b>
      </h4>
      <FourChildApp
        name={"캔디"}
        age={"23"}
        addr={"제주도"}
        increate={changeCount}
      />
      <FourChildApp
        name={"완다"}
        age={"30"}
        addr={"울릉도"}
        increate={changeCount}
      />
      <FourChildApp
        name={"진나"}
        age={"25"}
        addr={"순천"}
        increate={changeCount}
      />
    </div>
  );
}

export default MainApp;

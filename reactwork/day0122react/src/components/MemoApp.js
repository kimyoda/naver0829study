import React, {useState} from "react";
import ShowState from "./ShowState";

const MemoApp = () => {
  const [number, setNumber] = useState(0);
  const [text, setText] = useState("");

  const increaseNumber = () => {
    setNumber(number + 1);
  };

  const decreaseNumber = () => {
    setNumber(number - 1);
  };

  const onChangeTextHandler = (e) => {
    setText(e.target.value);
  };

  return (
    <div>
      <button className="btn btn-danger btn-sm" onClick={increaseNumber}>
        증가
      </button>
      <br />
      <br />
      <button className="btn btn-danger btn-sm" onClick={decreaseNumber}>
        감소
      </button>
      <br />
      <br />
      <input
        type="text"
        placeholder="input name"
        onChange={onChangeTextHandler}
      />
      <hr />
      <ShowState number={number} text={text} />
    </div>
  );
};

export default MemoApp;

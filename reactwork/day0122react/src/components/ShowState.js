import React, {useMemo} from "react";

const getNumger = (number) => {
  console.log("숫자가 변동되었습니다");
  return number;
};
const getText = (text) => {
  console.log("문자가 변동되었습니다");
  return text;
};
const ShowState = ({number, text}) => {
  // 숫자만 변경되면 숫자만 변경되었다고 나와야하나 전체가 다시 렌더링되면서
  // 현재는 두 가지 메세지가 같이 나온다
  // const showNumber = getNumger(number);
  // const showText = getText(text);

  // useMemo는 렌더링 최적화 하기 위한 기능이다.
  const showNumber = useMemo(() => getNumger(number), [number]);
  const showText = useMemo(() => getText(text), [text]);

  return (
    <div>
      <h3>{showNumber}</h3>
      <h3>{showText}</h3>
    </div>
  );
};

export default ShowState;

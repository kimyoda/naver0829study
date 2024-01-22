import React, {useCallback, useState} from "react";
import Light from "./Light";

const SweetHome = () => {
  const [masterOn, setMasterOn] = useState(false);
  const [kitchenOn, setKitchenOn] = useState(false);
  const [bathOn, setBathOn] = useState(false);

  // 각 room의 불을 켜고꺼는 이벤트들
  // const toggleMaster = () => {
  //   setMasterOn(!masterOn);
  // };
  // const toggleKitchen = () => {
  //   setKitchenOn(!kitchenOn);
  // };
  // const toggleBatch = () => {
  //   setBathOn(!bathOn);
  // };

  // useCallback을 ㅈ거용하면 해당 변수가 바뀔경우에만 렌더링이 일어난다
  const toggleMaster = useCallback(() => {
    setMasterOn(!masterOn);
  }, [masterOn]);
  const toggleKitchen = useCallback(() => {
    setKitchenOn(!kitchenOn);
  }, [kitchenOn]);
  const toggleBatch = useCallback(() => {
    setBathOn(!bathOn);
  }, [bathOn]);

  return (
    // 렌더링이 전체로 돼니깐 다시 출력이 됀다. 나머지는 호출이 안되게 하나만 렌더링 되게 하려고 할 때는 어떻게 바꾸면 돼나
    <div>
      <Light room={"침실"} on={masterOn} toggle={toggleMaster} />
      <Light room={"주방"} on={kitchenOn} toggle={toggleKitchen} />
      <Light room={"욕실"} on={bathOn} toggle={toggleBatch} />
    </div>
  );
};

export default SweetHome;

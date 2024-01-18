import {Alert} from "@mui/material";
import React from "react";
import {useParams} from "react-router-dom";
import lunFoodImg from "../image/1.jpg";
import desFoodImg from "../image/11.jpg";
import anotherFoodImg from "../image/4.jpg";

const Food = () => {
  const {food1, food2} = useParams();
  console.log({food1}, {food2});
  return (
    <div>
      <Alert variant="filled" severity="error">
        Food 컴포넌트입니다
      </Alert>
      <hr />
      {food1 == null && food2 == null ? (
        <h3>오늘 점심 안먹겠습니다</h3>
      ) : food1 != null && food2 == null ? (
        <div>
          <h4>오늘의 점심 메뉴</h4>
          <img alt="" src={require(`../image/${food1}.jpg`)} width={300} />
          <h1>오늘 후식은 없다</h1>
        </div>
      ) : (
        <div>
          <h4>오늘의 점심 메뉴</h4>
          <img alt="" src={require(`../image/${food1}.jpg`)} width={300} />
          <h4>오늘 후식</h4>
          <img alt="" src={require(`../image/${food2}.jpg`)} width={300} />
        </div>
      )}
    </div>
  );
};

export default Food;

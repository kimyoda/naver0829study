import React, {useContext} from "react";
import {ThemeContext} from "./ThemeContext";
import {UserContext} from "./UserContext";
import {DollContext} from "./DollContext";

const Content = () => {
  const {isDark, doll} = useContext(ThemeContext);
  const user = useContext(UserContext);

  return (
    <div
      className="content"
      style={{backgroundColor: isDark ? "gray" : "white"}}
    >
      <p>{user}님! 즐거운 하루 되세요~!</p>
      <img alt="" src={require(`../image/${doll}`)} width="300px" />
    </div>
  );
};

export default Content;

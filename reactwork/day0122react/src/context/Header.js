import React, {useContext} from "react";
import {ThemeContext} from "./ThemeContext";
import {UserContext} from "./UserContext";

const Header = () => {
  const {isDark, doll} = useContext(ThemeContext);
  const user = useContext(UserContext);

  return (
    <header
      className="header"
      style={{backgroundColor: isDark ? "black" : "lightgray"}}
    >
      <h1>Weclome {user}!</h1>
      <img alt="" src={require(`../image/${doll}`)} width="60px" />
    </header>
  );
};

export default Header;

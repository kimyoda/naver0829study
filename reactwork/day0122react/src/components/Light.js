import React from "react";

const Light = ({room, on, toggle}) => {
  console.log({room, on});

  return (
    <div>
      <button onClick={toggle}>
        {room}
        {on ? "💡" : "⬛"}
      </button>
    </div>
  );
};

// export default Light;
// memo 메모리제이션, 최적화시키는 것
export default React.memo(Light);

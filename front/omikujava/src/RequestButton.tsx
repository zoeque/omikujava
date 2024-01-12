import React, { useState } from 'react';
import axios from 'axios';

const RequestButton = ({ onResult }) => {
  const handleClick = async () => {
    try {
      const response = await axios.get('http://localhost:8080/omikuji');
      console.log(response.data);
      onResult(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div>
      <button onClick={handleClick}>占う</button>
    </div>
  );
};

export default RequestButton;
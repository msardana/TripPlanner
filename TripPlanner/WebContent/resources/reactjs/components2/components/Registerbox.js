import React from 'react';
import Sidebar from 'react-sidebar';

import { IndexLink, Link } from "react-router";

export default class registerbox extends React.Component {

  constructor(props) {
    super(props);
  }

  render(){
  return (
    <div id="sidb">
      <ul className="igniteSidebar-nav">

    <li id="plan" >
      <Link to="/plantripadminstration">UserName</Link>
    </li>
    <li id="ongoing" >
      <Link to="/ongoingtripadminstration">Register</Link>
    </li>
    <li id="mytrip" >
      <Link to="/mytrupookadminstration">Contact Us</Link>
    </li>

  </ul>
  </div>
  );
  }
  }

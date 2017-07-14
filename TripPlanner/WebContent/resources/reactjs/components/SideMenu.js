import React from 'react';
import Sidebar from 'react-sidebar';

import {Route, IndexLink, Link } from "react-router-dom";


export default class SideMenu extends React.Component {

  constructor(props) {
    super(props);
  }

  render(){
  return (
    <div id="sidb">
      <ul id="nav1" className="igniteSidebar-nav">

    <li id="plantrip" >
      <Link id="l1" to="/plantripadminstration">Plan Trip</Link>
    </li>
    <li id="ongoingtrip" >
      <Link id="l1" to="/ongoingtripadminstration">OnGoing Trip</Link>
    </li>
    <li id="mytripbook" >
      <Link id="l1" to="/mytrupookadminstration">My TripBook</Link>
    </li>
    <li id="shareview">
      <Link id="l1" to="/shareviewadminstration">share/view</Link>
    </li>
  </ul>
  </div>
  );
  }
  }

import 'babel-polyfill';
import React from 'react';
import ReactDOM from 'react-dom';
import DestinationDetailBox from './components/DestinationDetailBox';
require('./css/styles.css');
ReactDOM.render(
    <DestinationDetailBox/>,document.getElementById("app")
)

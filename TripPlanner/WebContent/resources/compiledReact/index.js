'use strict';

require('babel-polyfill');

var _react = require('react');

var _react2 = _interopRequireDefault(_react);

var _reactDom = require('react-dom');

var _reactDom2 = _interopRequireDefault(_reactDom);

var _DestinationDetailBox = require('./components/DestinationDetailBox');

var _DestinationDetailBox2 = _interopRequireDefault(_DestinationDetailBox);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

_reactDom2.default.render(_react2.default.createElement(_DestinationDetailBox2.default, null), document.getElementById("app"));

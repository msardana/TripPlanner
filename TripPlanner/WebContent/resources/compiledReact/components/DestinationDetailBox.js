"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _react = require("react");

var _react2 = _interopRequireDefault(_react);

var _LoginRegister = require("./LoginRegister");

var _LoginRegister2 = _interopRequireDefault(_LoginRegister);

var _TransportMode = require("./TransportMode");

var _TransportMode2 = _interopRequireDefault(_TransportMode);

var _SightSeeingBox = require("./SightSeeingBox");

var _SightSeeingBox2 = _interopRequireDefault(_SightSeeingBox);

var _SideMenu = require("./SideMenu");

var _SideMenu2 = _interopRequireDefault(_SideMenu);

var _Planbox = require("./Planbox");

var _Planbox2 = _interopRequireDefault(_Planbox);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var DestinationDetailBox = function (_React$Component) {
  _inherits(DestinationDetailBox, _React$Component);

  function DestinationDetailBox() {
    _classCallCheck(this, DestinationDetailBox);

    return _possibleConstructorReturn(this, (DestinationDetailBox.__proto__ || Object.getPrototypeOf(DestinationDetailBox)).apply(this, arguments));
  }

  _createClass(DestinationDetailBox, [{
    key: "render",
    value: function render() {
      return _react2.default.createElement(
        "div",
        { className: "container", id: "s" },
        _react2.default.createElement(
          "div",
          { id: "a4" },
          _react2.default.createElement(_LoginRegister2.default, null)
        ),
        _react2.default.createElement(
          "div",
          { id: "a5" },
          _react2.default.createElement(_Planbox2.default, null)
        ),
        _react2.default.createElement(
          "div",
          { id: "a3" },
          _react2.default.createElement(
            "div",
            { id: "a2" },
            _react2.default.createElement(_SideMenu2.default, null)
          )
        )
      );
    }
  }]);

  return DestinationDetailBox;
}(_react2.default.Component);

exports.default = DestinationDetailBox;

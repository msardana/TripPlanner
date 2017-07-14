'use strict';

Object.defineProperty(exports, "__esModule", {
  value: true
});

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _react = require('react');

var _react2 = _interopRequireDefault(_react);

var _reactSidebar = require('react-sidebar');

var _reactSidebar2 = _interopRequireDefault(_reactSidebar);

var _reactRouterDom = require('react-router-dom');

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var SideMenu = function (_React$Component) {
  _inherits(SideMenu, _React$Component);

  function SideMenu(props) {
    _classCallCheck(this, SideMenu);

    return _possibleConstructorReturn(this, (SideMenu.__proto__ || Object.getPrototypeOf(SideMenu)).call(this, props));
  }

  _createClass(SideMenu, [{
    key: 'render',
    value: function render() {
      return _react2.default.createElement(
        'div',
        { id: 'sidb' },
        _react2.default.createElement(
          'ul',
          { id: 'nav1', className: 'igniteSidebar-nav' },
          _react2.default.createElement(
            'li',
            { id: 'plantrip' },
            _react2.default.createElement(
              _reactRouterDom.Link,
              { id: 'l1', to: '/plantripadminstration' },
              'Plan Trip'
            )
          ),
          _react2.default.createElement(
            'li',
            { id: 'ongoingtrip' },
            _react2.default.createElement(
              _reactRouterDom.Link,
              { id: 'l1', to: '/ongoingtripadminstration' },
              'OnGoing Trip'
            )
          ),
          _react2.default.createElement(
            'li',
            { id: 'mytripbook' },
            _react2.default.createElement(
              _reactRouterDom.Link,
              { id: 'l1', to: '/mytrupookadminstration' },
              'My TripBook'
            )
          ),
          _react2.default.createElement(
            'li',
            { id: 'shareview' },
            _react2.default.createElement(
              _reactRouterDom.Link,
              { id: 'l1', to: '/shareviewadminstration' },
              'share/view'
            )
          )
        )
      );
    }
  }]);

  return SideMenu;
}(_react2.default.Component);

exports.default = SideMenu;

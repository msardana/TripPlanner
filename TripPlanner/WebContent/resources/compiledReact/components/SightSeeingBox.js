'use strict';

Object.defineProperty(exports, "__esModule", {
    value: true
});

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _react = require('react');

var _react2 = _interopRequireDefault(_react);



function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var SightSeeingBox = function (_React$Component) {
    _inherits(SightSeeingBox, _React$Component);

    function SightSeeingBox(props) {
        _classCallCheck(this, SightSeeingBox);

        var _this = _possibleConstructorReturn(this, (SightSeeingBox.__proto__ || Object.getPrototypeOf(SightSeeingBox)).call(this, props));

        _this.state = {};
        return _this;
    }

    _createClass(SightSeeingBox, [{
        key: 'setAge',
        value: function setAge(event) {
            this.setState({ lastName: event.target.value });
        }
    }, {
        key: 'displayUser',
        value: function displayUser(event) {
            var data = this.state.firstName + this.state.lastName;
            document.getElementById("display").innerHTML = data;
        }
    }, {
        key: 'render',
        value: function render() {
            var ser = {

                width: '28em',
                height: '3em',
                textAlign: 'center',

                padding: '0px',
                marginTop: '10px',
                marginBottom: '10px'
            };
            return _react2.default.createElement(
                'div',
                { id: 'total', className: 'container-fluid' },
                _react2.default.createElement(
                    'h4',
                    { id: 'cen' },
                    'PLAN SIGHTSEEING '
                ),
                _react2.default.createElement(
                    'div',
                    { className: 'row' },
                    _react2.default.createElement(
                        'div',
                        { className: 'col col-lg-6' },
                        _react2.default.createElement(
                            'div',
                            { className: 'input-group' },
                            _react2.default.createElement(
                                'span',
                                { className: 'input-group-addon', id: 'basic-addon1' },
                                '@'
                            ),
                            _react2.default.createElement('input', { type: 'text', placeholder: 'Select tour destination ', 'aria-describedby': 'basic-addon1' })
                        ),
                        _react2.default.createElement('p', null),
                        _react2.default.createElement(
                            'div',
                            { className: 'input-group' },
                            _react2.default.createElement(
                                'span',
                                { className: 'input-group-addon', id: 'basic-addon1' },
                                '@'
                            ),
                            _react2.default.createElement('input', { type: 'text', placeholder: 'Start from', 'aria-describedby': 'basic-addon1' })
                        ),
                        _react2.default.createElement('p', null),
                        _react2.default.createElement(
                            'div',
                            { className: 'input-group' },
                            _react2.default.createElement(
                                'span',
                                { className: 'input-group-addon', id: 'basic-addon1' },
                                '@'
                            ),
                            _react2.default.createElement('input', { type: 'text', placeholder: 'Date', 'aria-describedby': 'basic-addon1' })
                        ),
                        _react2.default.createElement('p', null),
                        _react2.default.createElement(
                            'div',
                            { className: 'input-group' },
                            _react2.default.createElement(
                                'span',
                                { className: 'input-group-addon', id: 'basic-addon1' },
                                '@'
                            ),
                            _react2.default.createElement('input', { type: 'text', placeholder: '   no of people', 'aria-describedby': 'basic-addon1' })
                        ),
                        _react2.default.createElement('p', null),
                        _react2.default.createElement(
                            'div',
                            { className: 'input-group' },
                            _react2.default.createElement(
                                'span',
                                { className: 'input-group-addon', id: 'basic-addon1' },
                                '@'
                            ),
                            _react2.default.createElement('input', { type: 'text', 'class': 'form-control', id: 'pwd' })
                        ),
                        _react2.default.createElement('p', null),
                        _react2.default.createElement(
                            'div',
                            { id: 'textbox1', className: 'form-group' },
                            _react2.default.createElement('label', { 'for': 'formGroupExampleInput2' }),
                            _react2.default.createElement('input', { type: 'text', className: 'col-xs-5', placeholder: 'Males'
                            })
                        ),
                        _react2.default.createElement(
                            'div',
                            { id: 'textbox2', className: 'form-group' },
                            _react2.default.createElement('label', { 'for': 'formGroupExampleInput2' }),
                            _react2.default.createElement('input', { type: 'text', className: 'col-xs-5', placeholder: 'Females'
                            })
                        ),
                        _react2.default.createElement('p', null),
                        _react2.default.createElement(
                            'div',
                            { id: 'textbox3', className: 'form-group' },
                            _react2.default.createElement('label', { 'for': 'formGroupExampleInput2' }),
                            _react2.default.createElement('input', { type: 'text', className: 'col-xs-5', placeholder: 'Kids'
                            })
                        ),
                        _react2.default.createElement(
                            'div',
                            { id: 'textbox4', className: 'form-group' },
                            _react2.default.createElement('label', { 'for': 'formGroupExampleInput2' }),
                            _react2.default.createElement('input', { type: 'text', className: 'col-xs-5', placeholder: 'Seniors'
                            })
                        ),
                        _react2.default.createElement('p', { id: 'display' }),
                        _react2.default.createElement(
                            'button',
                            { type: 'submit', style: ser, id: 'search', className: 'btn btn-primary', onClick: this.displayUser.bind(this) },
                            'SEARCH SIGHT SEEING'
                        )
                    )
                )
            );
        }
    }]);

    return SightSeeingBox;
}(_react2.default.Component);

exports.default = SightSeeingBox;

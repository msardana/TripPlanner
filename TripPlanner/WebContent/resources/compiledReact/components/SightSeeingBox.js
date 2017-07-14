'use strict';

Object.defineProperty(exports, "__esModule", {
    value: true
});

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _react = require('react');

var _react2 = _interopRequireDefault(_react);

var _reactDatepicker = require('react-datepicker');

var _reactDatepicker2 = _interopRequireDefault(_reactDatepicker);

var _moment = require('moment');

var _moment2 = _interopRequireDefault(_moment);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var SightSeeingBox = function (_React$Component) {
    _inherits(SightSeeingBox, _React$Component);

    function SightSeeingBox(props) {
        _classCallCheck(this, SightSeeingBox);

        var _this = _possibleConstructorReturn(this, (SightSeeingBox.__proto__ || Object.getPrototypeOf(SightSeeingBox)).call(this, props));

        _this.state = {
            startDate: (0, _moment2.default)()
        };
        _this.handleChange = _this.handleChange.bind(_this);
        return _this;
    }

    _createClass(SightSeeingBox, [{
        key: 'handleChange',
        value: function handleChange(date) {
            this.setState({
                startDate: date
            });
        }
    }, {
        key: 'firstMethod',
        value: function firstMethod(e) {
            var re = /[a-zA-Z:]+/g;
            if (!re.test(e.key)) {
                e.preventDefault();
            }
        }
    }, {
        key: 'secondMethod',
        value: function secondMethod(e) {
            var re = /[0-9:]+/g;
            if (!re.test(e.key)) {
                e.preventDefault();
            }
        }
    }, {
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
            var _this2 = this;

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
                                'div',
                                { className: 'input-group-addon' },
                                _react2.default.createElement('span', { className: 'glyphicon glyphicon-map-marker', id: 'basic-addon1' })
                            ),
                            _react2.default.createElement('input', { type: 'text', placeholder: 'Select tour destination ', onKeyPress: function onKeyPress(e) {
                                    return _this2.firstMethod(e);
                                }, 'aria-describedby': 'basic-addon1' })
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
                            _react2.default.createElement('input', { type: 'text', placeholder: 'Start from', onKeyPress: function onKeyPress(e) {
                                    return _this2.firstMethod(e);
                                }, 'aria-describedby': 'basic-addon1' })
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
                            _react2.default.createElement(_reactDatepicker2.default, {
                                selected: this.state.startDate,
                                onChange: this.handleChange,
                                placeholderText: 'Click to select a date'
                            })
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
                            _react2.default.createElement('input', { type: 'text', placeholder: 'No of people', onKeyPress: function onKeyPress(e) {
                                    return _this2.secondMethod(e);
                                }, 'aria-describedby': 'basic-addon1' })
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
                            _react2.default.createElement('input', { type: 'text', 'class': 'form-control', onKeyPress: function onKeyPress(e) {
                                    return _this2.firstMethod(e);
                                }, id: 'pwd' })
                        ),
                        _react2.default.createElement('p', null),
                        _react2.default.createElement(
                            'div',
                            { id: 'textbox1', className: 'form-group' },
                            _react2.default.createElement('label', { 'for': 'formGroupExampleInput2' }),
                            _react2.default.createElement(
                                'select',
                                { type: 'text', className: 'col-xs-5', placeholder: 'Males', onKeyPress: function onKeyPress(e) {
                                        return _this2.secondMethod(e);
                                    } },
                                _react2.default.createElement(
                                    'option',
                                    { value: '', disabled: true, selected: true },
                                    'Males'
                                ),
                                _react2.default.createElement(
                                    'option',
                                    { value: 'val1' },
                                    '0 Male'
                                ),
                                _react2.default.createElement(
                                    'option',
                                    { value: 'val2' },
                                    '1 Male'
                                ),
                                _react2.default.createElement(
                                    'option',
                                    { value: 'val3' },
                                    '2 Males'
                                ),
                                _react2.default.createElement(
                                    'option',
                                    { value: 'val4' },
                                    '3 Males'
                                )
                            )
                        ),
                        _react2.default.createElement(
                            'div',
                            { id: 'textbox2', className: 'form-group' },
                            _react2.default.createElement('label', { 'for': 'formGroupExampleInput2' }),
                            _react2.default.createElement(
                                'select',
                                { type: 'text', className: 'col-xs-5', placeholder: 'Fenales', onKeyPress: function onKeyPress(e) {
                                        return _this2.secondMethod(e);
                                    } },
                                _react2.default.createElement(
                                    'option',
                                    { value: '', disabled: true, selected: true },
                                    'Females'
                                ),
                                _react2.default.createElement(
                                    'option',
                                    { value: 'val1' },
                                    '0 Female'
                                ),
                                _react2.default.createElement(
                                    'option',
                                    { value: 'val2' },
                                    '1 Female'
                                ),
                                _react2.default.createElement(
                                    'option',
                                    { value: 'val3' },
                                    '2 Females'
                                ),
                                _react2.default.createElement(
                                    'option',
                                    { value: 'val4' },
                                    '3 Females'
                                )
                            )
                        ),
                        _react2.default.createElement('p', null),
                        _react2.default.createElement(
                            'div',
                            { id: 'textbox3', className: 'form-group' },
                            _react2.default.createElement('label', { 'for': 'formGroupExampleInput2' }),
                            _react2.default.createElement(
                                'select',
                                { type: 'text', className: 'col-xs-5', placeholder: 'Kids', onKeyPress: function onKeyPress(e) {
                                        return _this2.secondMethod(e);
                                    } },
                                _react2.default.createElement(
                                    'option',
                                    { value: '', disabled: true, selected: true },
                                    'Kids'
                                ),
                                _react2.default.createElement(
                                    'option',
                                    { value: 'val1' },
                                    '0 Child'
                                ),
                                _react2.default.createElement(
                                    'option',
                                    { value: 'val2' },
                                    '1 Child'
                                ),
                                _react2.default.createElement(
                                    'option',
                                    { value: 'val3' },
                                    '2 Children'
                                ),
                                _react2.default.createElement(
                                    'option',
                                    { value: 'val4' },
                                    '3 Children'
                                )
                            )
                        ),
                        _react2.default.createElement(
                            'div',
                            { id: 'textbox4', className: 'form-group' },
                            _react2.default.createElement('label', { 'for': 'formGroupExampleInput2' }),
                            _react2.default.createElement(
                                'select',
                                { className: 'col-xs-5', placeholder: 'Seniors', onKeyPress: function onKeyPress(e) {
                                        return _this2.secondMethod(e);
                                    } },
                                _react2.default.createElement(
                                    'option',
                                    { value: '', disabled: true, selected: true },
                                    'Seniors'
                                ),
                                _react2.default.createElement(
                                    'option',
                                    { value: 'val1' },
                                    '0 Seniors'
                                ),
                                _react2.default.createElement(
                                    'option',
                                    { value: 'val2' },
                                    '1 Seniors'
                                ),
                                _react2.default.createElement(
                                    'option',
                                    { value: 'val3' },
                                    '2 Seniors'
                                ),
                                _react2.default.createElement(
                                    'option',
                                    { value: 'val4' },
                                    '3 Seniorsn'
                                )
                            )
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

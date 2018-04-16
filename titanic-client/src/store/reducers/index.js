import { combineReducers } from 'redux';
import {passengerReducer} from './PassengerReducer';

const titanicReducer = combineReducers({
  passengerReducer
});

export default titanicReducer
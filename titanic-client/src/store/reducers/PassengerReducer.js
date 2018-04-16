import {ADD_PASSENGER, ERROR_LOADING, FETCH_PASSENGERS} from '../actions/PassengerActions';

const initState = {
  passengers: [],
  loading: true
};

export function passengerReducer(state = initState, action) {
  switch (action.type) {
    case ADD_PASSENGER:
      return {
        ...state,
        passengers: [
          action.payload,
          ...state.passengers
        ]
      };
    case FETCH_PASSENGERS:
      return {
        passengers: action.payload,
        loading: false
      };
    case ERROR_LOADING:
    default:
      return state;
  }
}
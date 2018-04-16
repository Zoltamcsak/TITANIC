export const FETCH_PASSENGERS = 'FETCH_PASSENGERS';
export const ADD_PASSENGER = 'ADD_PASSENGER';
export const ERROR_LOADING = 'ERROR_LOADING';

/**
 * Action creator for fetching passengers.
 * It uses redux-promise to convert result from promise to Passenger
 * @returns {{type: string, payload: Promise<any>}}
 */
export function fetchPassengers() {
  const passengers = fetch('/api/passengers')
    .then(response => response.json())
    .catch(errorLoading);
  return {
    type: FETCH_PASSENGERS,
    payload: passengers
  }
}

/**
 * Action creator for adding a new passenger
 * @param passenger
 * @returns {{type: string, payload: Promise<any>}}
 */
export function addPassenger(passenger) {
  const passengerPromise = fetch('/api/passengers', {
    method: 'POST',
    body: JSON.stringify(passenger),
    headers: {
      'Content-Type': 'application/json'
    }
  })
    .then(res => res.json())
    .catch(errorLoading);
  return {
    type: ADD_PASSENGER,
    payload: passengerPromise
  }
}

export function errorLoading(error) {
  console.error(`An error happened: ${error}`);
  return {
    type: ERROR_LOADING,
    payload: error
  }
}
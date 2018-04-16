export const FETCH_PASSENGERS = 'FETCH_PASSENGERS';
export const ADD_PASSENGER = 'ADD_PASSENGER';
export const ERROR_LOADING = 'ERROR_LOADING';

export function fetchPassengers() {
  const passengers = fetch('/api/passengers')
    .then(response => response.json())
    .catch(errorLoading);
  return {
    type: FETCH_PASSENGERS,
    payload: passengers
  }
}

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
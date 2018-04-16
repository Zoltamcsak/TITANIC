import React, {Component} from 'react';
import './App.css';
import PassegerList from './passengers/PassengerList';
import AddPassenger from './add-passenger/AddPassenger';

class App extends Component {
  render() {
    return (
      <div className="App">
        <AddPassenger/>
        <PassegerList/>
      </div>
    );
  }
}

export default App;

import React, {Component} from 'react';
import Button from 'material-ui/Button';
import PassengerModal from './PassengerModal';

export default class AddPassenger extends Component {
  constructor() {
    super();
    this.state = {
      dialogOpen: false
    }
  }

  handleOpen = () => {
    this.setState({
      dialogOpen: true
    });
  };

  handleClose = () => {
    this.setState({
      dialogOpen: false
    });
  };

  handleSubmit = (passenger) => {
    this.setState({
      dialogOpen: false
    });
    fetch('/api/passengers', {
      method: 'POST',
      body: JSON.stringify(passenger),
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(console.log);
    this.handleClose()
  };

  render() {
    return (
      <div>
        <Button onClick={this.handleOpen}>Add</Button>
        <PassengerModal open={this.state.dialogOpen}
                        handleClose={this.handleClose}
                        handleSubmit={this.handleSubmit}/>
      </div>
    );
  }
}
import React, {Component} from 'react';
import Button from 'material-ui/Button';
import PassengerModal from './PassengerModal';
import {addPassenger} from '../store/actions/PassengerActions';
import {connect} from 'react-redux';

class AddPassenger extends Component {
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
    this.props.addPassenger(passenger);
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

const mapDispatchToProps = (dispatch) => ({
  addPassenger: (passenger) => dispatch(addPassenger(passenger))
});

export default connect(null, mapDispatchToProps)(AddPassenger);

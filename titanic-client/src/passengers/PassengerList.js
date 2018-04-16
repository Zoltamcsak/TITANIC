import PassengerItem from './PassengerItem';
import React, {Component} from 'react';
import Table, { TableBody, TableCell, TableHead, TableRow } from 'material-ui/Table';
import Paper from 'material-ui/Paper';
import {fetchPassengers} from '../store/actions/PassengerActions';
import { connect } from 'react-redux'

class PassengerList extends Component {
  componentDidMount() {
    this.props.getPassengers();
  }

  render() {
    if (this.props.loading) {
      return <p>Loading</p>
    }
    return (
      <Paper>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>Name</TableCell>
              <TableCell>Age</TableCell>
              <TableCell>No of Siblings or Spouses</TableCell>
              <TableCell>No of Parent or Children</TableCell>
              <TableCell>Ticket number</TableCell>
              <TableCell>Passenger fare</TableCell>
              <TableCell>Port of Embarkation</TableCell>
              <TableCell>Survived</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {this.props.passengers.map(passenger => {
                return <PassengerItem key={passenger.id} passenger={passenger}/>
              }
            )}
          </TableBody>
        </Table>
      </Paper>
    );
  }
}

const mapStateToProps = (state) => {
  return {
    passengers: state.passengerReducer.passengers,
    loading: state.passengerReducer.loading
  }
};

const mapDispatchToProps = dispatch => ({
  getPassengers: () => dispatch(fetchPassengers())
});

export default connect(mapStateToProps, mapDispatchToProps)(PassengerList);

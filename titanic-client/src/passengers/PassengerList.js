import PassengerItem from './PassengerItem';
import React, {Component} from 'react';
import Table, { TableBody, TableCell, TableHead, TableRow } from 'material-ui/Table';
import Paper from 'material-ui/Paper';

export default class PassengerList extends Component {
  constructor() {
    super();
    this.state = {
      passengers: [],
      loading: true
    };
  }

  componentDidMount() {
    fetch('/api/passengers')
      .then(response => response.json())
      .then(result => {
        this.setState({
          passengers: result,
          loading: false
        });
      });
  }

  render() {
    if (this.state.loading) {
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
            {this.state.passengers.map(passenger => {
                return <PassengerItem key={passenger.id} passenger={passenger}/>
              }
            )}
          </TableBody>
        </Table>
      </Paper>
    );
  }
}

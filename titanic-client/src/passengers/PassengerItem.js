import React from 'react';
import { TableRow, TableCell } from 'material-ui/Table';

const PassengerItem = ({passenger}) => {
  return (
    <TableRow key={passenger.id}>
      <TableCell>{passenger.name}</TableCell>
      <TableCell>{passenger.age}</TableCell>
      <TableCell>{passenger.nrOfSiblings}</TableCell>
      <TableCell>{passenger.nrOfParent}</TableCell>
      <TableCell>{passenger.ticketNumber}</TableCell>
      <TableCell>{passenger.fare}</TableCell>
      <TableCell>{passenger.embarkation}</TableCell>
      <TableCell>{passenger.survived}</TableCell>
    </TableRow>
  )
};

export default PassengerItem;
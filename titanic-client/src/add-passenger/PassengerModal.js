import React, {Component} from 'react';
import Modal from 'material-ui/Modal';
import Button from 'material-ui/Button';
import { withStyles } from 'material-ui/styles';
import TextField from 'material-ui/TextField';
import Select from 'material-ui/Select';
import { InputLabel } from 'material-ui/Input';
import { MenuItem } from 'material-ui/Menu';

const styles = theme => ({
  paper: {
    position: 'absolute',
    width: theme.spacing.unit * 50,
    backgroundColor: theme.palette.background.paper,
    boxShadow: theme.shadows[5],
    padding: theme.spacing.unit * 4,
  },
});

const formStyle = {
  display: 'flex',
  flexDirection: 'column'
};

class PassengerModal extends Component {
  constructor(props) {
    super(props);
    this.state = {
      form: this.getFormInitValue()
    };
  }

  getFormInitValue() {
    return {
      passengerClass: '',
      name: '',
      sex: 'Male',
      age: 0,
      nrOfSiblings: 0,
      nrOfParent: 0,
      ticketNumber: '',
      fare: 0.0,
      cabin: '',
      embarkation: '',
      lifeBoat: '',
      survived: ''
    }
  }

  handleChange = (event) => {
    const target = event.target;

    this.setState({
      form: {
        ...this.state.form,
        ...{[target.name]: target.value}
      }
    });
  };

  handleSubmit = (event) => {
    event.preventDefault();
    this.props.handleSubmit(this.state.form);
  };

  render() {
    const { classes } = this.props;
    return (
      <Modal open={this.props.open}
             onClose={this.props.handleClose}>
        <div className={classes.paper}>
          <form onSubmit={this.handleSubmit} style={formStyle}>
            <TextField
              id="passengerClass"
              name="passengerClass"
              label="Passenger class"
              className={classes.textField}
              value={this.state.form.passengerClass}
              onChange={this.handleChange}
              margin="normal"
            />
            <TextField
              id="name"
              name="name"
              label="Name"
              className={classes.textField}
              value={this.state.form.name}
              onChange={this.handleChange}
              margin="normal"
            />
            <Select
              value={this.state.form.sex}
              onChange={this.handleChange}
              inputProps={{
                name: 'age',
                id: 'age',
              }}>
              <MenuItem value={'Male'}>Male</MenuItem>
              <MenuItem value={'Female'}>Female</MenuItem>
            </Select>
            <TextField
            id="age"
            name="age"
            label="Age"
            type="number"
            className={classes.textField}
            value={this.state.form.age}
            onChange={this.handleChange}
            margin="normal"
          />
            <TextField
              id="nrOfSiblings"
              name="nrOfSiblings"
              label="Nr of siblings"
              type="number"
              className={classes.textField}
              value={this.state.form.nrOfSiblings}
              onChange={this.handleChange}
              margin="normal"
            />
            <TextField
              id="nrOfParent"
              name="nrOfParent"
              label="Nr of parent"
              type="number"
              className={classes.textField}
              value={this.state.form.nrOfParent}
              onChange={this.handleChange}
              margin="normal"
            />
            <TextField
              id="ticketNumber"
              name="ticketNumber"
              label="Ticket number"
              className={classes.textField}
              value={this.state.form.ticketNumber}
              onChange={this.handleChange}
              margin="normal"
            />
            <TextField
              id="fare"
              name="fare"
              label="Fare"
              className={classes.textField}
              value={this.state.form.fare}
              onChange={this.handleChange}
              margin="normal"
            />
            <TextField
              id="cabin"
              name="cabin"
              label="Cabin"
              className={classes.textField}
              value={this.state.form.cabin}
              onChange={this.handleChange}
              margin="normal"
            />
            <TextField
              id="embarkation"
              name="embarkation"
              label="Embarkation"
              className={classes.textField}
              value={this.state.form.embarkation}
              onChange={this.handleChange}
              margin="normal"
            />
            <InputLabel htmlFor="lifeBoat">Life boat</InputLabel>
            <Select
              value={this.state.form.lifeBoat}
              onChange={this.handleChange}
              inputProps={{
                name: 'lifeBoat',
                id: 'lifeBoat',
              }}>
              <MenuItem value='true'>Yes</MenuItem>
              <MenuItem value='false'>No</MenuItem>
            </Select>
            <InputLabel htmlFor="survived">Survived</InputLabel>
            <Select
              value={this.state.form.survived}
              onChange={this.handleChange}
              inputProps={{
                name: 'survived',
                id: 'survived',
              }}>
              <MenuItem value='true'>Yes</MenuItem>
              <MenuItem value='false'>No</MenuItem>
            </Select>
            <Button type='submit'>Add</Button>
          </form>
        </div>
      </Modal>
    );
  }
}

// We need an intermediary variable for handling the recursive nesting.
export default PassengerModal = withStyles(styles)(PassengerModal);

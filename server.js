const express = require('express');
const cors = require('cors');
const app = express();
app.use(cors());
app.use(express.json());

let patients = [
  {id: 1, name: "Ayush Jain", age: 21, disease: "Checkup"}
];
let appointments = [];

app.get('/', (req, res) => {
  res.send('Hospital Backend Live - Roll No 105 Ayush Jain');
});

app.get('/patients', (req, res) => {
  res.json(patients);
});

app.post('/patients', (req, res) => {
  const newPatient = {id: patients.length + 1, ...req.body};
  patients.push(newPatient);
  res.json({message: 'Patient Added Successfully', patients});
});

app.delete('/patients/:id', (req, res) => {
  patients.splice(req.params.id, 1);
  res.json(patients);
});

app.get('/appointments', (req,res) => res.json(appointments));

app.post('/appointments', (req, res) => {
  appointments.push(req.body);
  res.json({message: 'Appointment Booked'});
});

app.get('/stats', (req,res) => {
  res.json({totalPatients: patients.length, totalAppointments: appointments.length});
});

const PORT = process.env.PORT || 10000;
app.listen(PORT, () => console.log('Server Running on ' + PORT));

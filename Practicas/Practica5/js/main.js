var app = new (function () {
  //Coleccion de tanques de gas
  var gas1 = {
    nombre: 'ESTANDAR',
    capacidad: '30',
    hora: new Date(),
    costobase: 500,
    costoneto: 0,
    imagen: 'img/gas3.jpeg',
    reservas: [],
  };
  var gas2 = {
    nombre: 'BASICO',
    capacidad: '20',
    hora: new Date(),
    costobase: 450,
    costoneto: 0,
    imagen: 'img/gas2.png',
    reservas: [],
  };
  var gas3 = {
    nombre: 'FAMILIAR',
    capacidad: '50',
    hora: new Date(),
    costobase: 600,
    costoneto: 0,
    imagen: 'img/gas4.jpeg',
    reservas: [],
  };
  var gas4 = {
    nombre: 'PREMIUM',
    capacidad: '40',
    hora: new Date(),
    costobase: 550,
    costoneto: 0,
    imagen: 'img/gas5.jpeg',
    reservas: [],
  };
  var gas5 = {
    nombre: 'ESTUDIANTE',
    capacidad: '10',
    hora: new Date(),
    costobase: 200,
    costoneto: 0,
    imagen: 'img/gas1.jpeg',
    reservas: [],
  };
  this.gass = [gas1, gas2, gas3, gas4, gas5];
  for (var i = 0; i < this.gass.length; i++) {
    var aumentomanana = 0;
    var aumentofindesemana = 0;
    if (this.gass[i].hora.getHours() <= 12) {
      aumentomanana = this.gass[i].costobase * 0.05;
    }
    if (this.gass[i].hora.getDay() == 5 || this.gass[i].hora.getDay() == 6) {
      aumentofindesemana = this.gass[i].costobase * 0.1;
    }
    this.gass[i].costoneto = this.gass[i].costobase + aumentomanana + aumentofindesemana;
  }

  this.mostrarGas = function () {
    var data = '<br>';
    if (this.gass.length > 0) {
      for (i = 0; i < this.gass.length; i++) {
        data += '<tr>';
        data +=
          '<td style= "background-color:white;"># ' +
          (i + 1) +
          ' ' +
          this.gass[i].nombre +
          ', CAPACIDAD: ' +
          this.gass[i].capacidad +
          ' KG ' +
          ', PRECIO: $' +
          this.gass[i].costobase +
          '<img src="' +
          this.gass[i].imagen +
          '" width="100" height="100" />' +
          '</td>';
        data += '<td ; ><button class="btn btn-primary"  onclick="app.Reservar(' + i + ')">Reservar</button></td>';
        data += '</tr>';
      }
    }
    document.getElementById('gass').innerHTML = data;
    document.getElementById('gass').style.display = 'block';
  };

  this.Reservar = function (item) {
    var el = document.getElementById('documento');
    document.getElementById('documento').value = '';
    document.getElementById('datosgas').style.display = 'block';
    document.getElementById('gass').style.display = 'none';
    document.getElementById('menu1').style.display = 'none';
    document.getElementById('menu2').style.display = 'none';
    document.getElementById('btnback').style.display = 'block';

    var impuesto = this.gass[item].costobase == this.gass[item].costoneto ? '' : 'Impuesto mañana y/o fin de semana';
    var hora = this.gass[item].hora.getHours() < 10 ? '0' + this.gass[item].hora.getHours() : this.gass[item].hora.getHours();
    var minutos = this.gass[item].hora.getMinutes() < 10 ? '0' + this.gass[item].hora.getMinutes() : this.gass[item].hora.getMinutes();

    document.getElementById('datosgas').innerHTML =
      'GAS # ' +
      (item + 1) +
      ':<br>NOMBRE: ' +
      this.gass[item].nombre +
      '<br>CAPACIDAD: ' +
      this.gass[item].capacidad +
      '<br>SALIDA: ' +
      this.gass[item].hora.toDateString() +
      ' ' +
      hora +
      ':' +
      minutos +
      '<br>PRECIO BASE: $' +
      this.gass[item].costobase +
      '<br>PRECIO NETO: $' +
      this.gass[item].costoneto +
      ' ' +
      impuesto +
      // mostrar imagen
      '<img src="' +
      this.gass[item].imagen +
      '" width="100" height="100" />';
    document.getElementById('campodoc').style.display = 'block';
    self = this;
    document.getElementById('reserva-edit').onsubmit = function () {
      var d = el.value * 1;
      if (isNaN(d) || d == 0) {
        window.alert('Ingrese un número de celular correcto');
      } else {
        var flag = false;
        for (j = 0; j < self.gass.length; j++) {
          var auxDoc = self.gass[j].reservas.indexOf(d);
          if (auxDoc != -1) {
            if (
              self.gass[j].hora.getFullYear() == self.gass[item].hora.getFullYear() &&
              self.gass[j].hora.getMonth() == self.gass[item].hora.getMonth() &&
              self.gass[j].hora.getDate() == self.gass[item].hora.getDate()
            ) {
              flag = true;
              break;
            }
          }
        }

        // Solo 1 persona puede reservar el gas
        if (self.gass[item].reservas.length > 0) {
          flag = true;
          window.alert('Lo sentimos ya esta apartado');
          return false;
        } else {
          self.gass[item].reservas.push(d);
          window.alert('GAS reservado correctamente');
          document.getElementById('menu1').style.display = 'block';
          document.getElementById('menu2').style.display = 'block';
          document.getElementById('datosgas').style.display = 'none';
          document.getElementById('campodoc').style.display = 'none';
          document.getElementById('btnback').style.display = 'none';
        }
      }
    };
  };

  this.consultarReserva = function () {
    var el = document.getElementById('docConsulta');
    var d = el.value * 1;
    if (isNaN(d) || d == 0) {
      window.alert('Ingrese un dato correcto');
    } else {
      var data = '<br>TANQUES RESERVADOS DE ' + d;
      for (i = 0; i < this.gass.length; i++) {
        var auxDoc = this.gass[i].reservas.indexOf(d);
        if (auxDoc != -1) {
          var hora = this.gass[i].hora.getHours() < 10 ? '0' + this.gass[i].hora.getHours() : this.gass[i].hora.getHours();
          var minutos = this.gass[i].hora.getMinutes() < 10 ? '0' + this.gass[i].hora.getMinutes() : this.gass[i].hora.getMinutes();

          //Tabla con los datos
          data += '<table class="table-responsive" border="1" width="100%">';
          // data += '<tr>';
          data += '<td>ID ' + (i + 1) + '</td>';
          // data += '<tr>';
          data += '<td>NOMBRE: ' + this.gass[i].nombre + '</td>';
          // data += '<tr>';
          data += '<td>CAPACIDAD: ' + this.gass[i].capacidad + '</td>';
          // data += '<tr>';
          data += '<td>PRECIO NETO: $' + this.gass[i].costoneto + '</td>';
          // data += '<tr>';
          data += '<td>SALIDA: ' + this.gass[i].hora.toDateString() + ' ' + hora + ':' + minutos + '</td>';
          data += '<td><img src="' + this.gass[i].imagen + '" width="100" height="100" /></td>';
          //Valores th
          data += '</tr>';
          data += '</table>';
        }
      }
      if (data == '<br>gass RESERVADOS DE ' + d) {
        window.alert('No existen gass asociados a dicho documento');
      } else {
        document.getElementById('menu1').style.display = 'none';
        document.getElementById('menu2').style.display = 'none';
        document.getElementById('gass').style.display = 'block';
        document.getElementById('gass').innerHTML = data;
        document.getElementById('btnback').style.display = 'block';
      }
    }
  };

  this.Volver = function () {
    document.getElementById('datosgas').style.display = 'none';
    document.getElementById('campodoc').style.display = 'none';
    document.getElementById('gass').style.display = 'none';
    document.getElementById('btnback').style.display = 'none';
    document.getElementById('menu1').style.display = 'block';
    document.getElementById('menu2').style.display = 'block';
    document.getElementById('docConsulta').value = '';
  };
})();

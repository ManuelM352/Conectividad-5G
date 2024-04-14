package com.example.conectividad5g

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.Manifest


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Verificar si ya se ha otorgado el permiso
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
            != PackageManager.PERMISSION_GRANTED
        ) {
            // Si el permiso no está otorgado, solicitarlo
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_PHONE_STATE),
                PERMISSION_REQUEST_CODE
            )
        } else {
            // Si el permiso ya está otorgado, iniciar la lógica de la aplicación
            initAppLogic()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {
            // Verificar si el permiso fue otorgado
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                // Permiso otorgado, iniciar la lógica de la aplicación
                initAppLogic()
            } else {
                // Permiso denegado, mostrar mensaje de que la aplicación no puede funcionar sin el permiso
                Toast.makeText(this, "La aplicación no puede funcionar sin el permiso", Toast.LENGTH_SHORT).show()
                // O cerrar la aplicación
                finish()
            }
        }
    }

    private fun initAppLogic() {
        // Iniciar la lógica de la aplicación aquí, por ejemplo, mostrar la pantalla de inicio
        setContent {
            // Aquí deberías mostrar tu composición principal
            ConnectivityScreen()
        }
    }

    companion object {
        private const val PERMISSION_REQUEST_CODE = 100
    }
}
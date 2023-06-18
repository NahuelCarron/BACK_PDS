package ar.edu.unsam.pds.services

import com.google.cloud.texttospeech.v1.AudioConfig;
import com.google.cloud.texttospeech.v1.AudioEncoding;
import com.google.cloud.texttospeech.v1.SsmlVoiceGender;
import com.google.cloud.texttospeech.v1.SynthesisInput;
import com.google.cloud.texttospeech.v1.TextToSpeechClient;
import com.google.cloud.texttospeech.v1.VoiceSelectionParams;
import org.springframework.stereotype.Service
import java.io.FileOutputStream;

@Service
class AudioService {

    fun audio_voz() {
        TextToSpeechClient.create().use { textToSpeechClient ->
            // Set the text input to be synthesized
            val input: SynthesisInput = SynthesisInput.newBuilder().setText("hola perras").build()

            // Build the voice request, select the language code ("es-US") and the ssml voice gender
            // ("neutral")
            val voice: VoiceSelectionParams = VoiceSelectionParams.newBuilder()
                .setLanguageCode("es-US")
                .setSsmlGender(SsmlVoiceGender.NEUTRAL)
                .build()

            // Select the type of audio file you want returned
            val audioConfig: AudioConfig = AudioConfig.newBuilder()
                .setAudioEncoding(AudioEncoding.MP3)
                .build()

            // Perform the text-to-speech request on the text input with the selected voice parameters and
            // audio file type
            val response = textToSpeechClient.synthesizeSpeech(input, voice, audioConfig)

            // Get the audio contents from the response
            val audioContents = response.audioContent

            // Write the response to the output file.
            FileOutputStream("output.mp3").use { out ->
                out.write(audioContents.toByteArray())
                println("Audio content written to file \"output.mp3\"")
            }
        }
    }
}
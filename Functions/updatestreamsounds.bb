Function updatestreamsounds%()
    Local local0.events
    Local local1.fps_settings
    local1 = (First fps_settings)
    If (0.0 < local1\Field3[$00]) Then
        If (intercomstreamchn <> $00) Then
            setstreamvolume_strict(intercomstreamchn, sfxvolume)
        EndIf
        For local0 = Each events
            If (local0\Field6 <> $00) Then
                If (local0\Field12 <> 0) Then
                    setstreamvolume_strict(local0\Field6, sfxvolume)
                EndIf
            EndIf
            If (local0\Field7 <> $00) Then
                If (local0\Field13 <> 0) Then
                    setstreamvolume_strict(local0\Field7, sfxvolume)
                EndIf
            EndIf
            If (local0\Field8 <> $00) Then
                If (local0\Field14 <> 0) Then
                    setstreamvolume_strict(local0\Field8, sfxvolume)
                EndIf
            EndIf
        Next
    EndIf
    If (playerinreachableroom($00) = $00) Then
        If (((playerroom\Field7\Field10 <> "gateb") And (playerroom\Field7\Field10 <> "gatea")) <> 0) Then
            If (intercomstreamchn <> $00) Then
                stopstream_strict(intercomstreamchn)
                intercomstreamchn = $00
            EndIf
            If (playerroom\Field7\Field10 <> "dimension1499") Then
                For local0 = Each events
                    If (((local0\Field6 <> $00) And local0\Field12) <> 0) Then
                        stopstream_strict(local0\Field6)
                        local0\Field6 = $00
                        local0\Field12 = $00
                    EndIf
                    If (((local0\Field7 <> $00) And local0\Field13) <> 0) Then
                        stopstream_strict(local0\Field7)
                        local0\Field6 = $00
                        local0\Field12 = $00
                    EndIf
                    If (((local0\Field8 <> $00) And local0\Field14) <> 0) Then
                        stopstream_strict(local0\Field8)
                        local0\Field6 = $00
                        local0\Field12 = $00
                    EndIf
                Next
            EndIf
        EndIf
    EndIf
    Return $00
End Function

Function killsounds%()
    Local local0%
    Local local1.events
    Local local2.npcs
    Local local3.doors
    Local local4.devilemitters
    Local local5.sound
    For local0 = $00 To $09 Step $01
        If (tempsounds[local0] <> $00) Then
            freesound_strict(tempsounds[local0])
            tempsounds[local0] = $00
        EndIf
    Next
    For local1 = Each events
        If (local1\Field6 <> $00) Then
            If (local1\Field12 = $00) Then
                If (channelplaying(local1\Field6) <> 0) Then
                    stopchannel(local1\Field6)
                EndIf
            Else
                stopstream_strict(local1\Field6)
            EndIf
        EndIf
        If (local1\Field7 <> $00) Then
            If (local1\Field13 = $00) Then
                If (channelplaying(local1\Field7) <> 0) Then
                    stopchannel(local1\Field7)
                EndIf
            Else
                stopstream_strict(local1\Field7)
            EndIf
        EndIf
        If (local1\Field8 <> $00) Then
            If (local1\Field14 = $00) Then
                If (channelplaying(local1\Field8) <> 0) Then
                    stopchannel(local1\Field8)
                EndIf
            Else
                stopstream_strict(local1\Field8)
            EndIf
        EndIf
    Next
    For local2 = Each npcs
        If (local2\Field17 <> $00) Then
            If (local2\Field72 = $00) Then
                If (channelplaying(local2\Field17) <> 0) Then
                    stopchannel(local2\Field17)
                EndIf
            Else
                stopstream_strict(local2\Field17)
            EndIf
        EndIf
        If (local2\Field20 <> $00) Then
            If (local2\Field73 = $00) Then
                If (channelplaying(local2\Field20) <> 0) Then
                    stopchannel(local2\Field20)
                EndIf
            Else
                stopstream_strict(local2\Field20)
            EndIf
        EndIf
    Next
    For local3 = Each doors
        If (local3\Field16 <> $00) Then
            If (channelplaying(local3\Field16) <> 0) Then
                stopchannel(local3\Field16)
            EndIf
        EndIf
    Next
    For local4 = Each devilemitters
        If (local4\Field8 <> $00) Then
            If (channelplaying(local4\Field8) <> 0) Then
                stopchannel(local4\Field8)
            EndIf
        EndIf
    Next
    If (ambientsfxchn <> $00) Then
        If (channelplaying(ambientsfxchn) <> 0) Then
            stopchannel(ambientsfxchn)
        EndIf
    EndIf
    If (breathchn <> $00) Then
        If (channelplaying(breathchn) <> 0) Then
            stopchannel(breathchn)
        EndIf
    EndIf
    If (intercomstreamchn <> $00) Then
        stopstream_strict(intercomstreamchn)
        intercomstreamchn = $00
    EndIf
    If (enablesfxrelease <> 0) Then
        For local5 = Each sound
            If (local5\Field0 <> $00) Then
                freesound(local5\Field0)
                local5\Field0 = $00
                local5\Field3 = $00
            EndIf
        Next
    EndIf
    For local5 = Each sound
        For local0 = $00 To $1F Step $01
            If (local5\Field2[local0] <> $00) Then
                stopchannel(local5\Field2[local0])
            EndIf
        Next
    Next
    Return $00
End Function

Function pausesounds%()
    Local local0.events
    Local local1.npcs
    Local local2.doors
    Local local3.devilemitters
    For local0 = Each events
        If (local0\Field6 <> $00) Then
            If (local0\Field12 = $00) Then
                If (channelplaying(local0\Field6) <> 0) Then
                    pausechannel(local0\Field6)
                EndIf
            Else
                setstreampaused_strict(local0\Field6, $01)
            EndIf
        EndIf
        If (local0\Field7 <> $00) Then
            If (local0\Field13 = $00) Then
                If (channelplaying(local0\Field7) <> 0) Then
                    pausechannel(local0\Field7)
                EndIf
            Else
                setstreampaused_strict(local0\Field7, $01)
            EndIf
        EndIf
        If (local0\Field8 <> $00) Then
            If (local0\Field14 = $00) Then
                If (channelplaying(local0\Field8) <> 0) Then
                    pausechannel(local0\Field8)
                EndIf
            Else
                setstreampaused_strict(local0\Field8, $01)
            EndIf
        EndIf
    Next
    For local1 = Each npcs
        If (local1\Field17 <> $00) Then
            If (local1\Field72 = $00) Then
                If (channelplaying(local1\Field17) <> 0) Then
                    pausechannel(local1\Field17)
                EndIf
            ElseIf (local1\Field72 = $01) Then
                setstreampaused_strict(local1\Field17, $01)
            EndIf
        EndIf
        If (local1\Field20 <> $00) Then
            If (local1\Field73 = $00) Then
                If (channelplaying(local1\Field20) <> 0) Then
                    pausechannel(local1\Field20)
                EndIf
            ElseIf (local1\Field73 = $01) Then
                setstreampaused_strict(local1\Field20, $01)
            EndIf
        EndIf
    Next
    For local2 = Each doors
        If (local2\Field16 <> $00) Then
            If (channelplaying(local2\Field16) <> 0) Then
                pausechannel(local2\Field16)
            EndIf
        EndIf
    Next
    For local3 = Each devilemitters
        If (local3\Field8 <> $00) Then
            If (channelplaying(local3\Field8) <> 0) Then
                pausechannel(local3\Field8)
            EndIf
        EndIf
    Next
    If (ambientsfxchn <> $00) Then
        If (channelplaying(ambientsfxchn) <> 0) Then
            pausechannel(ambientsfxchn)
        EndIf
    EndIf
    If (breathchn <> $00) Then
        If (channelplaying(breathchn) <> 0) Then
            pausechannel(breathchn)
        EndIf
    EndIf
    If (intercomstreamchn <> $00) Then
        setstreampaused_strict(intercomstreamchn, $01)
    EndIf
    Return $00
End Function

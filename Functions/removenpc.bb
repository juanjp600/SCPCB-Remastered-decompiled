Function removenpc%(arg0.npcs)
    If (arg0 = Null) Then
        Return $00
    EndIf
    If (arg0\Field1 <> $00) Then
        freeentity(arg0\Field1)
        arg0\Field1 = $00
    EndIf
    If (arg0\Field2 <> $00) Then
        freeentity(arg0\Field2)
        arg0\Field2 = $00
    EndIf
    If (arg0\Field3 <> $00) Then
        freeentity(arg0\Field3)
        arg0\Field3 = $00
    EndIf
    If (arg0\Field72 = $00) Then
        If (((arg0\Field17 <> $00) And channelplaying(arg0\Field17)) <> 0) Then
            stopchannel(arg0\Field17)
        EndIf
    ElseIf (arg0\Field17 <> $00) Then
        stopstream_strict(arg0\Field17)
    EndIf
    If (arg0\Field73 = $00) Then
        If (((arg0\Field20 <> $00) And channelplaying(arg0\Field20)) <> 0) Then
            stopchannel(arg0\Field20)
        EndIf
    ElseIf (arg0\Field20 <> $00) Then
        stopstream_strict(arg0\Field20)
    EndIf
    If (arg0\Field16 <> $00) Then
        freesound_strict(arg0\Field16)
    EndIf
    If (arg0\Field19 <> $00) Then
        freesound_strict(arg0\Field19)
    EndIf
    freeentity(arg0\Field0)
    arg0\Field0 = $00
    freeentity(arg0\Field4)
    arg0\Field4 = $00
    Delete arg0
    Return $00
End Function

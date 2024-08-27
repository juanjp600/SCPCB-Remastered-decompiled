Function removeevent%(arg0.events)
    If (arg0\Field9 <> $00) Then
        freesound_strict(arg0\Field9)
    EndIf
    If (arg0\Field10 <> $00) Then
        freesound_strict(arg0\Field10)
    EndIf
    If (arg0\Field11 <> $00) Then
        freesound_strict(arg0\Field11)
    EndIf
    If (arg0\Field16 <> $00) Then
        freeimage(arg0\Field16)
    EndIf
    Delete arg0
    Return $00
End Function

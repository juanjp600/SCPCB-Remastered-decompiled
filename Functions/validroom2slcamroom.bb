Function validroom2slcamroom%(arg0.rooms)
    Local local0$
    If (arg0 = Null) Then
        Return $00
    EndIf
    local0 = arg0\Field7\Field10
    If (local0 = "room2closets") Then
        Return $01
    EndIf
    If (local0 = "room1archive") Then
        Return $01
    EndIf
    If (local0 = "room3z3") Then
        Return $01
    EndIf
    If (local0 = "room1lifts") Then
        Return $01
    EndIf
    If (local0 = "checkpoint1") Then
        Return $01
    EndIf
    If (local0 = "room2nuke") Then
        Return $01
    EndIf
    If (local0 = "room008") Then
        Return $01
    EndIf
    If (local0 = "room1162") Then
        Return $01
    EndIf
    If (local0 = "room966") Then
        Return $01
    EndIf
    If (local0 = "room2ccont") Then
        Return $01
    EndIf
    If (local0 = "room457") Then
        Return $01
    EndIf
    If (local0 = "room409") Then
        Return $01
    EndIf
    If (local0 = "room106") Then
        Return $01
    EndIf
    Return $00
    Return $00
End Function
